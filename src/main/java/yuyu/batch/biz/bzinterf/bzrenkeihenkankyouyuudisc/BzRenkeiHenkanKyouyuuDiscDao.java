package yuyu.batch.biz.bzinterf.bzrenkeihenkankyouyuudisc;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.exception.ExIllegalArgumentException;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 連携項目変換処理（共有ディスク方式）DAOクラスです。
 */
public class BzRenkeiHenkanKyouyuuDiscDao {

    @Inject
    ExDBEntityManager exDBEntityManager;


    public <T> ExDBResults<T> getAllByTableid(String pTableid) {

        try {
            String PREFIX = "yuyu.def.db.id.PK";
            String className = PREFIX.concat(pTableid);
            Class<?> clazz = Class.forName(className);
            Field[] fs = clazz.getDeclaredFields();

            List<String> sortKeyArr = new ArrayList<String>() ;
            for (int i = 1; fs.length > i; i ++) {
                sortKeyArr.add(fs[i].getName());
            }

            String jpql = $SELECT  + " t1 " + $FROM +  pTableid  + " as t1 "  + $ORDER_BY(sortKeyArr.toArray()) ;

            return exDBEntityManager.createJPQL(jpql).getResults();


        } catch (ClassNotFoundException e) {
            throw new ExIllegalArgumentException(e, "指定されたテーブルID[" + pTableid + "]は不正です。");
        }

    }

    public Long getCountByTableid(String pTableid) {
        String jpql = $SELECT  + $COUNT + " (*) " + $FROM +  pTableid  ;

        return exDBEntityManager.createJPQL(jpql).getSingleResult();
    }

    public void truncateByTableid(String pTableid) {
        String strSql = "truncate table " + pTableid;
        exDBEntityManager.createNativeSQL(strSql).executeUpdate();
    }

    public void deleteByTableid(String pTableid) {

        String strSql = $DELETE_FROM + pTableid ;

        exDBEntityManager.createJPQL(strSql).executeUpdate();
    }
}
