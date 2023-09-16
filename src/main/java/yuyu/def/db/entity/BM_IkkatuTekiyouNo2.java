package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenBM_IkkatuTekiyouNo2;

import com.google.common.collect.Lists;

/**
 * 一括払適用番号マスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_IkkatuTekiyouNo2} の JavaDoc を参照してください。<br />
 * @see     GenBM_IkkatuTekiyouNo2<br />
 * @see     PKBM_IkkatuTekiyouNo2<br />
 * @see     QBM_IkkatuTekiyouNo2<br />
 * @see     GenQBM_IkkatuTekiyouNo2<br />
 */
@Entity
public class BM_IkkatuTekiyouNo2 extends GenBM_IkkatuTekiyouNo2 {

    private static final long serialVersionUID = 1L;

    public BM_IkkatuTekiyouNo2() {
    }

    public BM_IkkatuTekiyouNo2(String pSyouhncd, String pRyouritusdno, BizNumber pYoteiriritu, String pIkttekiyoubr1,
        String pIkttekiyoubr2, String pIkttekiyoubr3) {
        super(pSyouhncd, pRyouritusdno, pYoteiriritu, pIkttekiyoubr1, pIkttekiyoubr2, pIkttekiyoubr3);
    }

    private List<BM_IkkatuKeisuu> bM_IkkatuKeisuu = Lists.newLinkedList();

    @OneToMany
    @JoinColumns({
        @JoinColumn(name = BM_IkkatuTekiyouNo2.IKTTEKIYOUNO, referencedColumnName = BM_IkkatuKeisuu.IKTTEKIYOUNO, insertable = false, updatable = false)
    })
    @OrderBy(BM_IkkatuKeisuu.IKTTEKIYOUNO + " ASC ," + BM_IkkatuKeisuu.NEN1NEN2BARAIHYOUJI + " ASC ,"
        + BM_IkkatuKeisuu.KEIKATUKISUU + " ASC ")
    public List<BM_IkkatuKeisuu> getIkkatuKeisuus() {
        return bM_IkkatuKeisuu;
    }

    public void setIkkatuKeisuus(List<BM_IkkatuKeisuu> pBM_IkkatuKeisuus) {
        this.bM_IkkatuKeisuu = pBM_IkkatuKeisuus;
    }

}
