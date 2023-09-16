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
import yuyu.def.db.mapping.GenIT_BAK_TesuuryouSyouhnRireki;


/**
 * 手数料情報商品履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_TesuuryouSyouhnRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_TesuuryouSyouhnRireki<br />
 * @see     PKIT_BAK_TesuuryouSyouhnRireki<br />
 * @see     QIT_BAK_TesuuryouSyouhnRireki<br />
 * @see     GenQIT_BAK_TesuuryouSyouhnRireki<br />
 */
@Entity
public class IT_BAK_TesuuryouSyouhnRireki extends GenIT_BAK_TesuuryouSyouhnRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_TesuuryouSyouhnRireki() {
    }

    public IT_BAK_TesuuryouSyouhnRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pTsrysyorikbn,pRenno,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

    public IT_BAK_TesuuryouSyouhnRireki(String pSyono,String pTrkssikibetukey,C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pTsrysyorikbn,pRenno,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }


    private IT_BAK_Tesuuryou iT_BAKTesuuryou ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_TesuuryouSyouhnRireki.KBNKEY  , referencedColumnName=IT_BAK_Tesuuryou.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TesuuryouSyouhnRireki.SYONO  , referencedColumnName=IT_BAK_Tesuuryou.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TesuuryouSyouhnRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_Tesuuryou.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TesuuryouSyouhnRireki.TSRYSYORIKBN  , referencedColumnName=IT_BAK_Tesuuryou.TSRYSYORIKBN, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_TesuuryouSyouhnRireki.RENNO  , referencedColumnName=IT_BAK_Tesuuryou.RENNO, insertable=false, updatable=false)
    })
    public IT_BAK_Tesuuryou getBAKTesuuryou() {
        return iT_BAKTesuuryou;
    }

    public void setBAKTesuuryou(IT_BAK_Tesuuryou pIT_BAK_Tesuuryou) {
        this.iT_BAKTesuuryou = pIT_BAK_Tesuuryou;
    }

}

