package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.mapping.GenST_SkKessanSyukei;


/**
 * 新契約決算用集計元データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_SkKessanSyukei} の JavaDoc を参照してください。<br />
 * @see     GenST_SkKessanSyukei<br />
 * @see     PKST_SkKessanSyukei<br />
 * @see     QST_SkKessanSyukei<br />
 * @see     GenQST_SkKessanSyukei<br />
 */
@Entity
public class ST_SkKessanSyukei extends GenST_SkKessanSyukei {

    private static final long serialVersionUID = 1L;

    public ST_SkKessanSyukei() {
    }

    public ST_SkKessanSyukei(String pMosno,BizDate pDenymd,C_Kanjyoukmkcd pKanjyoukmkcd,C_TaisyakuKbn pTaisyakukbn,C_NaibuKeiyakuKbn pNaibukeiyakukbn,C_TekiyouKbn pTekiyoukbn,C_Segcd pSeg1cd) {
        super(pMosno,pDenymd,pKanjyoukmkcd,pTaisyakukbn,pNaibukeiyakukbn,pTekiyoukbn,pSeg1cd);
    }



    private BM_KanjyouKamoku bM_KanjyouKamoku ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=ST_SkKessanSyukei.KANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
    })
    public  BM_KanjyouKamoku getKanjyouKamoku() {
        return bM_KanjyouKamoku;
    }

    public void setKanjyouKamoku(BM_KanjyouKamoku pBM_KanjyouKamoku) {
        this.bM_KanjyouKamoku = pBM_KanjyouKamoku;
    }

    private BM_Segment bM_Segment ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=ST_SkKessanSyukei.SEG1CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment() {
        return bM_Segment;
    }

    public void setSegment(BM_Segment pBM_Segment) {
        this.bM_Segment = pBM_Segment;
    }

    private BM_TantouCd bM_TantouCd ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=ST_SkKessanSyukei.TANTOCD  , referencedColumnName=BM_TantouCd.TANTOCD, insertable=false, updatable=false)
    })
    public  BM_TantouCd getTantouCd() {
        return bM_TantouCd;
    }

    public void setTantouCd(BM_TantouCd pBM_TantouCd) {
        this.bM_TantouCd = pBM_TantouCd;
    }

}

