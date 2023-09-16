package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.mapping.GenIT_BAK_TesuuryouSyouhn;


/**
 * 手数料情報商品バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_TesuuryouSyouhn} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_TesuuryouSyouhn<br />
 * @see     PKIT_BAK_TesuuryouSyouhn<br />
 * @see     QIT_BAK_TesuuryouSyouhn<br />
 * @see     GenQIT_BAK_TesuuryouSyouhn<br />
 */
@Entity
public class IT_BAK_TesuuryouSyouhn extends GenIT_BAK_TesuuryouSyouhn {

    private static final long serialVersionUID = 1L;

    public IT_BAK_TesuuryouSyouhn() {
    }

    public IT_BAK_TesuuryouSyouhn(String pKbnkey,String pSyono,String pTrkssikibetukey,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pTsrysyorikbn,pRenno,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

    public IT_BAK_TesuuryouSyouhn(String pSyono,String pTrkssikibetukey,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pTsrysyorikbn,pRenno,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }


    private IT_BAK_Tesuuryou iT_BAKTesuuryou ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_TesuuryouSyouhn.KBNKEY  , referencedColumnName=IT_BAK_Tesuuryou.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TesuuryouSyouhn.SYONO  , referencedColumnName=IT_BAK_Tesuuryou.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TesuuryouSyouhn.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_Tesuuryou.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TesuuryouSyouhn.TSRYSYORIKBN  , referencedColumnName=IT_BAK_Tesuuryou.TSRYSYORIKBN, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TesuuryouSyouhn.RENNO  , referencedColumnName=IT_BAK_Tesuuryou.RENNO, insertable=false, updatable=false)
    })
    public IT_BAK_Tesuuryou getBAKTesuuryou() {
        return iT_BAKTesuuryou;
    }

    public void setBAKTesuuryou(IT_BAK_Tesuuryou pIT_BAK_Tesuuryou) {
        this.iT_BAKTesuuryou = pIT_BAK_Tesuuryou;
    }

}

