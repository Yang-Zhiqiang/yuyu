package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import yuyu.def.db.mapping.GenBM_IkkatuTekiyouNo;

import com.google.common.collect.Lists;


/**
 * 一括払適用番号マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_IkkatuTekiyouNo} の JavaDoc を参照してください。<br />
 * @see     GenBM_IkkatuTekiyouNo<br />
 * @see     PKBM_IkkatuTekiyouNo<br />
 * @see     QBM_IkkatuTekiyouNo<br />
 * @see     GenQBM_IkkatuTekiyouNo<br />
 */
@Entity
public class BM_IkkatuTekiyouNo extends GenBM_IkkatuTekiyouNo {

    private static final long serialVersionUID = 1L;

    public BM_IkkatuTekiyouNo() {
    }

    public BM_IkkatuTekiyouNo(String pSyouhncd,String pRyouritusdno) {
        super(pSyouhncd,pRyouritusdno);
    }



    private List<BM_IkkatuKeisuu> bM_IkkatuKeisuu = Lists.newLinkedList();

    @OneToMany
    @JoinColumns({
        @JoinColumn(name=BM_IkkatuTekiyouNo.IKTTEKIYOUNO  , referencedColumnName=BM_IkkatuKeisuu.IKTTEKIYOUNO, insertable=false, updatable=false)
    })

    @OrderBy(BM_IkkatuKeisuu.IKTTEKIYOUNO+" ASC ,"+BM_IkkatuKeisuu.NEN1NEN2BARAIHYOUJI+" ASC ,"+BM_IkkatuKeisuu.KEIKATUKISUU+" ASC ")
    public  List<BM_IkkatuKeisuu> getIkkatuKeisuus() {
        return bM_IkkatuKeisuu;
    }

    public void setIkkatuKeisuus(List<BM_IkkatuKeisuu> pBM_IkkatuKeisuus) {
        this.bM_IkkatuKeisuu = pBM_IkkatuKeisuus;
    }


}

