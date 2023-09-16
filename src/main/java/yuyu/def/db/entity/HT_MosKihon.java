package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_MosKihon;


/**
 * 申込基本テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosKihon} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosKihon<br />
 * @see     PKHT_MosKihon<br />
 * @see     QHT_MosKihon<br />
 * @see     GenQHT_MosKihon<br />
 */
@Entity
public class HT_MosKihon extends GenHT_MosKihon {

    private static final long serialVersionUID = 1L;

    public HT_MosKihon() {
    }

    public HT_MosKihon(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_MosKihon.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

    private BM_Syokugyou bM_Syokugyou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_MosKihon.HHKNSYKGYCD  , referencedColumnName=BM_Syokugyou.SYOKUGYOUCD, insertable=false, updatable=false)
    })
    public  BM_Syokugyou getSyokugyou() {
        return bM_Syokugyou;
    }

    public void setSyokugyou(BM_Syokugyou pBM_Syokugyou) {
        this.bM_Syokugyou = pBM_Syokugyou;
    }

    private HM_SkHokenSyuruiNo hM_SkHokenSyuruiNo ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_MosKihon.HKNSYURUINO  , referencedColumnName=HM_SkHokenSyuruiNo.HKNSYURUINO, insertable=false, updatable=false),
        @JoinColumn(name=HT_MosKihon.HKNSYURUINOSD  , referencedColumnName=HM_SkHokenSyuruiNo.HKNSYURUINOSD, insertable=false, updatable=false)
    })
    public  HM_SkHokenSyuruiNo getSkHokenSyuruiNo() {
        return hM_SkHokenSyuruiNo;
    }

    public void setSkHokenSyuruiNo(HM_SkHokenSyuruiNo pHM_SkHokenSyuruiNo) {
        this.hM_SkHokenSyuruiNo = pHM_SkHokenSyuruiNo;
    }

}

