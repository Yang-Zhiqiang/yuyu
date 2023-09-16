package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_HokenSyoukenHukaInfo;


/**
 * 保険証券付加情報データバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_HokenSyoukenHukaInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_HokenSyoukenHukaInfo<br />
 * @see     PKIT_BAK_HokenSyoukenHukaInfo<br />
 * @see     QIT_BAK_HokenSyoukenHukaInfo<br />
 * @see     GenQIT_BAK_HokenSyoukenHukaInfo<br />
 */
@Entity
public class IT_BAK_HokenSyoukenHukaInfo extends GenIT_BAK_HokenSyoukenHukaInfo {

    private static final long serialVersionUID = 1L;

    public IT_BAK_HokenSyoukenHukaInfo() {
    }

    public IT_BAK_HokenSyoukenHukaInfo(String pKbnkey,String pSyono,String pTrkssikibetukey,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pTyouhyouymd);
    }

    public IT_BAK_HokenSyoukenHukaInfo(String pSyono,String pTrkssikibetukey,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pTyouhyouymd);
    }


    private IT_BAK_HokenSyouken iT_BAKHokenSyouken ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_HokenSyoukenHukaInfo.KBNKEY  , referencedColumnName=IT_BAK_HokenSyouken.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HokenSyoukenHukaInfo.SYONO  , referencedColumnName=IT_BAK_HokenSyouken.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HokenSyoukenHukaInfo.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_HokenSyouken.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_HokenSyoukenHukaInfo.TYOUHYOUYMD  , referencedColumnName=IT_BAK_HokenSyouken.TYOUHYOUYMD, insertable=false, updatable=false)
    })
    public IT_BAK_HokenSyouken getBAKHokenSyouken() {
        return iT_BAKHokenSyouken;
    }

    public void setBAKHokenSyouken(IT_BAK_HokenSyouken pIT_BAK_HokenSyouken) {
        this.iT_BAKHokenSyouken = pIT_BAK_HokenSyouken;
    }

}

