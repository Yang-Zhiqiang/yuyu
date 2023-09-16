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
import yuyu.def.db.mapping.GenIT_TesuuryouSyouhn;


/**
 * 手数料情報商品テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TesuuryouSyouhn} の JavaDoc を参照してください。<br />
 * @see     GenIT_TesuuryouSyouhn<br />
 * @see     PKIT_TesuuryouSyouhn<br />
 * @see     QIT_TesuuryouSyouhn<br />
 * @see     GenQIT_TesuuryouSyouhn<br />
 */
@Entity
public class IT_TesuuryouSyouhn extends GenIT_TesuuryouSyouhn {

    private static final long serialVersionUID = 1L;

    public IT_TesuuryouSyouhn() {
    }

    public IT_TesuuryouSyouhn(String pKbnkey,String pSyono,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pKbnkey,pSyono,pTsrysyorikbn,pRenno,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

    public IT_TesuuryouSyouhn(String pSyono,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTsrysyorikbn,pRenno,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }


    private IT_Tesuuryou iT_Tesuuryou ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_TesuuryouSyouhn.KBNKEY  , referencedColumnName=IT_Tesuuryou.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_TesuuryouSyouhn.SYONO  , referencedColumnName=IT_Tesuuryou.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_TesuuryouSyouhn.TSRYSYORIKBN  , referencedColumnName=IT_Tesuuryou.TSRYSYORIKBN, insertable=false, updatable=false),
        @JoinColumn(name=IT_TesuuryouSyouhn.RENNO  , referencedColumnName=IT_Tesuuryou.RENNO, insertable=false, updatable=false)
    })
    public IT_Tesuuryou getTesuuryou() {
        return iT_Tesuuryou;
    }

    public void setTesuuryou(IT_Tesuuryou pIT_Tesuuryou) {
        this.iT_Tesuuryou = pIT_Tesuuryou;
    }

}

