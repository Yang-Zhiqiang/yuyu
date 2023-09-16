package yuyu.def.db.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

/**
 * 機能基幹テーブル ( AS_Kinou ) アクセス用の DAO クラスです。
 */
@ThreadScoped
public class AS_KinouDao extends AbstractDao<AS_Kinou> {

    protected AS_KinouDao() {
        super(AS_Kinou.class);
    }

    private AS_Kinou lastKinou = null;

    public AS_Kinou getAS_Kinou(final String pKinouId) {
        if (allKinous == null) {
            if ((lastKinou == null) || (! lastKinou.getKinouId().equals(pKinouId))) {
                AS_Kinou condEntity = new AS_Kinou();
                condEntity.setKinouId(pKinouId);
                lastKinou = selectOne(condEntity);
            }
            return lastKinou;
        }
        return Iterables.find(
            selectAll(),
            new Predicate<AS_Kinou>() {
                @Override
                public boolean apply(AS_Kinou kinou) {
                    return kinou.getKinouId().equals(pKinouId);
                }
            },
            null
        );
    }


    private static final Ordering<AS_Kinou> idOrder = new Ordering<AS_Kinou>() {
        @Override
        public int compare(AS_Kinou pKinou1, AS_Kinou pKinou2) {
            int result;

            result = pKinou1.getSubSystem().getSortNo().intValue() -
                pKinou2.getSubSystem().getSortNo().intValue();
            if (result != 0) {
                return result;
            }

            result = pKinou1.getCategory().getSortNo().intValue() -
                pKinou2.getCategory().getSortNo().intValue();
            if (result != 0) {
                return result;
            }

            return pKinou1.getSortNo().intValue() -
                pKinou2.getSortNo().intValue();
        }
    };

    private static final Ordering<AS_KinouMode> idOrderKinouMode = new Ordering<AS_KinouMode>() {
        @Override
        public int compare(AS_KinouMode pKinouMode1, AS_KinouMode pKinouMode2) {

            return pKinouMode1.getSortNo().intValue() -
                pKinouMode2.getSortNo().intValue();
        }
    };

    public List<AS_Kinou> getAllKinous4KinouList() {
        List<AS_Kinou> list = idOrder.sortedCopy(selectAll());

        int i =0;
        for(AS_Kinou kinou :list){
            list.get(i).setKinouModes(Sets.newLinkedHashSet(idOrderKinouMode.sortedCopy(kinou.getKinouModes())));
            i++;
        }

        return list;

    }

    public List<AS_Kinou> getKinousBySubSystem(final String pSubSystemId) {
        return idOrder.sortedCopy(
            Iterables.filter(
                selectAll(),
                new Predicate<AS_Kinou>() {
                    @Override
                    public boolean apply(AS_Kinou kinou) {
                        return kinou.getSubSystemId().equals(pSubSystemId);
                    }
                }
                )
            );

    }

    public List<AS_Kinou> getKinousByCategory(final String pCategoryId) {
        assert pCategoryId != null;
        return idOrder.sortedCopy(
            Iterables.filter(
                selectAll(),
                new Predicate<AS_Kinou>() {
                    @Override
                    public boolean apply(AS_Kinou kinou) {
                        return kinou.getCategoryId().equals(pCategoryId);
                    }
                }
            )
        );
    }


    public List<AS_Kinou> getAS_KinousByC_KinouKbn(final C_KinouKbn pC_KinouKbn) {
        return idOrder.sortedCopy(
            Iterables.filter(
                selectAll(),
                new Predicate<AS_Kinou>() {
                    @Override
                    public boolean apply(AS_Kinou kinou) {
                        return kinou.getKinouKbn().eq(pC_KinouKbn);
                    }
                }
            )
        );
    }

    private List<AS_Kinou> allKinous = null;

    @Override
    public List<AS_Kinou> select(AS_Kinou pCondition){
        return new ArrayList<>(new LinkedHashSet<>(super.select(pCondition)));
    }

    @Override
    public List<AS_Kinou> selectAll() {
        if (allKinous == null) {
            allKinous = new ArrayList<>(new LinkedHashSet<>(super.selectAll()));
        }
        return allKinous;
    }

    public List<AS_Kinou> getKinousBySyoricd(String pSyoricd) {


        AS_Kinou aS_Kinou = new AS_Kinou();
        aS_Kinou.setSyoricd(pSyoricd);


        return select(aS_Kinou);
    }

}
