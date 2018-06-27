package DB;

import android.content.Context;
import java.util.List;
import DB.Dao.PairDao;
import DB.Dao.PersonDao;
import DB.Dao.RewardDao;
import DB.Tables.Pair;
import DB.Tables.Person;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class QueryHandler {

    private SQLiteDB db;
    private PersonDao personDao;
    private PairDao pairDao;
    private RewardDao rewDao;

    public QueryHandler(Context context){
        db = SQLiteDB.getInstance(context);
        personDao = db.personDao();
        pairDao = db.pairDao();
        rewDao = db.rewardDao();
    }


    public Maybe<List<Person>> allPersons(){
        return Maybe.fromCallable(()
                -> personDao.getAllPersons())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Single<Long> addPair(Pair pair) {
        return Single.fromCallable(()
                -> pairDao.insertPair(pair))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //lage par //hente par //hente bruker //hete historikk //legge til reset //endre threshold
    //spørring etter parprogrammering på reset
    //



}
