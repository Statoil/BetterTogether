package DB.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.Date;
import java.util.List;

import DB.RewardType;
import DB.Tables.Reward;
import DB.Tables.Threshold;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface RewardDao {

    @Query("SELECT threshold FROM threshold_table WHERE type=:type")
    int getThreshold(RewardType type);

    @Query("SELECT COUNT(*) FROM threshold_table")
    int getEntries();

    @Query("SELECT date FROM reward_table WHERE date = (SELECT max(date) FROM reward_table WHERE type =:type)")
    Date getLastRewardDate(RewardType type);

    @Query("SELECT type FROM reward_table WHERE date = (SELECT max (date) FROM reward_table)")
    RewardType getLastRewardType();

    @Query("SELECT COUNT(*) FROM reward_table")
    int getNumberOfRewards();

    //0 equals false
    @Query("SELECT COUNT(*) FROM reward_table WHERE type = :type AND usedReward = 0")
    int numberOfUnusedRewards(RewardType type);

    @Query("SELECT * FROM reward_table WHERE type=:type AND usedReward=0")
    List<Reward> getEarliestUnusedReward(RewardType type);

    @Update
    int updateReward(Reward reward);

    @Insert
    long addReward(Reward reset);

    @Insert
    long[] addReward(Reward ... reset);

    @Insert(onConflict = REPLACE)
    long[] addThresholds(Threshold... newThresholds);

    @Update
    int setThreshold(Threshold newThreshold);

}
