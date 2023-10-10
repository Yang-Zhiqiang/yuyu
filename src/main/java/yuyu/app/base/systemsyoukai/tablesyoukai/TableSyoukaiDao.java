package yuyu.app.base.systemsyoukai.tablesyoukai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.AM_TblsRefLimitSosiki;
import yuyu.def.db.entity.AM_TblsSearchPattern;
import yuyu.def.db.entity.AM_TblsTarget;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * テーブル照会機能専用のDAOクラスです。<br />
 * クラス定義と全メソッドがパッケージプライベートになっています。<br />
 */
class TableSyoukaiDao {

    @Inject
    ExDBEntityManager em;

    List<AM_TblsTarget> getAllTblTargets(){
        return new ArrayList<>(new LinkedHashSet<>(em.findAll(AM_TblsTarget.class)));
    }

    List<AM_TblsTarget> getTblTargetsBySubsystemIdTableIdTableNm(String pSubsystemId, String pTableId, String pTableNm){
        List<AM_TblsTarget> allTblTarget = new ArrayList<>(new LinkedHashSet<>(em.findAll(AM_TblsTarget.class)));
        return ImmutableList.copyOf(Iterables.filter(allTblTarget, new TblTargetPredicate(pSubsystemId, pTableId, pTableNm)));
    }

    List<AM_TblsSearchPattern> getSearchPatternByTableIdSearchPtnNm(String pTableId, String searchPtnNm){
        AM_TblsSearchPattern searchPattern = new AM_TblsSearchPattern();
        searchPattern.setBaseTableId(pTableId);
        searchPattern.setBaseSearchPtnNm(searchPtnNm);
        List<AM_TblsSearchPattern> resultList = em.findListBy(searchPattern);
        Collections.sort(resultList, new Comparator<AM_TblsSearchPattern>(){
            @Override
            public int compare(AM_TblsSearchPattern o1, AM_TblsSearchPattern o2) {
                return o1.getSortNo().compareTo(o2.getSortNo());
            }
        });
        return resultList;
    }

    List<AM_TblsRefLimitSosiki> getTblsRefLimitSosiki(String pTableId){
        AM_TblsRefLimitSosiki tblsRefLimitSosiki = new AM_TblsRefLimitSosiki();
        tblsRefLimitSosiki.setBaseTableId(pTableId);
        return em.findListBy(tblsRefLimitSosiki);
    }

    class TblTargetPredicate implements Predicate<AM_TblsTarget> {

        String subsystemId;
        String tableId;
        String tableNm;

        TblTargetPredicate(String pSubsystemId, String pTableId, String pTableNm){
            this.subsystemId = pSubsystemId;
            this.tableId     = pTableId;
            this.tableNm     = pTableNm;
        }

        @Override
        public boolean apply(AM_TblsTarget target) {

            if(!Strings.isNullOrEmpty(subsystemId) && !target.getSubSystemId().equals(subsystemId)){
                return false;
            }

            if(!Strings.isNullOrEmpty(tableId) && !target.getBaseTableId().toLowerCase().startsWith(tableId.toLowerCase())){
                return false;
            }

            if(!Strings.isNullOrEmpty(tableNm) && target.getBaseTableNm().indexOf(tableNm) < 0){
                return false;
            }

            return true;
        }
    }

}
