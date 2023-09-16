package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.AT_BatchDate;
/**
 * バッチ日付テーブル(AT_BatchDate) テーブルアクセス用の DAO クラスです。
 *
 */
public class AT_BatchDateDao extends AbstractDao<AT_BatchDate> {

    public AT_BatchDateDao() {
        super(AT_BatchDate.class);
    }

    public BizDate getBatchDate() {
        List<AT_BatchDate> list =selectAll();
        if(list !=null && list.size()>0){
            return list.get(0).getBatchExecDate();
        }
        return null;
    }

    public AT_BatchDate getAT_BatchDate() {
        List<AT_BatchDate> list = selectAll();
        if(list !=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public List<AT_BatchDate> getAT_BatchDateAll() {
        List<AT_BatchDate> list = selectAll();
        return list;
    }

    public AT_BatchDate getAT_BatchDateByDate(BizDate pBatchExecDate){
        return selectOne(new AT_BatchDate(pBatchExecDate));
    }
}
