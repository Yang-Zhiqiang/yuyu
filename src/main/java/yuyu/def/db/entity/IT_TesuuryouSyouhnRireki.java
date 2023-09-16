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
import yuyu.def.db.mapping.GenIT_TesuuryouSyouhnRireki;


/**
 * 手数料情報商品履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TesuuryouSyouhnRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_TesuuryouSyouhnRireki<br />
 * @see     PKIT_TesuuryouSyouhnRireki<br />
 * @see     QIT_TesuuryouSyouhnRireki<br />
 * @see     GenQIT_TesuuryouSyouhnRireki<br />
 */
@Entity
public class IT_TesuuryouSyouhnRireki extends GenIT_TesuuryouSyouhnRireki {

    private static final long serialVersionUID = 1L;

    public IT_TesuuryouSyouhnRireki() {
    }

    public IT_TesuuryouSyouhnRireki(String pKbnkey,String pSyono,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pKbnkey,pSyono,pTsrysyorikbn,pRenno,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

    public IT_TesuuryouSyouhnRireki(String pSyono,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTsrysyorikbn,pRenno,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }


    private IT_Tesuuryou iT_Tesuuryou ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_TesuuryouSyouhnRireki.KBNKEY  , referencedColumnName=IT_Tesuuryou.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_TesuuryouSyouhnRireki.SYONO  , referencedColumnName=IT_Tesuuryou.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_TesuuryouSyouhnRireki.TSRYSYORIKBN  , referencedColumnName=IT_Tesuuryou.TSRYSYORIKBN, insertable=false, updatable=false),
        @JoinColumn(name=IT_TesuuryouSyouhnRireki.RENNO  , referencedColumnName=IT_Tesuuryou.RENNO, insertable=false, updatable=false)
    })
    public IT_Tesuuryou getTesuuryou() {
        return iT_Tesuuryou;
    }

    public void setTesuuryou(IT_Tesuuryou pIT_Tesuuryou) {
        this.iT_Tesuuryou = pIT_Tesuuryou;
    }

}

