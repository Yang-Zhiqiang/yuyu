package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_HokenSyoukenHukaInfo;


/**
 * 保険証券付加情報データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HokenSyoukenHukaInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_HokenSyoukenHukaInfo<br />
 * @see     PKIT_HokenSyoukenHukaInfo<br />
 * @see     QIT_HokenSyoukenHukaInfo<br />
 * @see     GenQIT_HokenSyoukenHukaInfo<br />
 */
@Entity
public class IT_HokenSyoukenHukaInfo extends GenIT_HokenSyoukenHukaInfo {

    private static final long serialVersionUID = 1L;

    public IT_HokenSyoukenHukaInfo() {
    }

    public IT_HokenSyoukenHukaInfo(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_HokenSyoukenHukaInfo(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


    private IT_HokenSyouken iT_HokenSyouken ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HokenSyoukenHukaInfo.KBNKEY  , referencedColumnName=IT_HokenSyouken.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HokenSyoukenHukaInfo.SYONO  , referencedColumnName=IT_HokenSyouken.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_HokenSyoukenHukaInfo.TYOUHYOUYMD  , referencedColumnName=IT_HokenSyouken.TYOUHYOUYMD, insertable=false, updatable=false)
    })
    public IT_HokenSyouken getHokenSyouken() {
        return iT_HokenSyouken;
    }

    public void setHokenSyouken(IT_HokenSyouken pIT_HokenSyouken) {
        this.iT_HokenSyouken = pIT_HokenSyouken;
    }

}

