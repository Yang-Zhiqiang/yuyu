package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_Suiihyou;


/**
 * 推移表テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_Suiihyou} の JavaDoc を参照してください。<br />
 * @see     GenIT_Suiihyou<br />
 * @see     PKIT_Suiihyou<br />
 * @see     QIT_Suiihyou<br />
 * @see     GenQIT_Suiihyou<br />
 */
@Entity
public class IT_Suiihyou extends GenIT_Suiihyou {

    private static final long serialVersionUID = 1L;

    public IT_Suiihyou() {
    }

    public IT_Suiihyou(String pKbnkey,String pSyono,BizDate pTyouhyouymd,Integer pKeikanensuu) {
        super(pKbnkey,pSyono,pTyouhyouymd,pKeikanensuu);
    }

    public IT_Suiihyou(String pSyono,BizDate pTyouhyouymd,Integer pKeikanensuu) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd,pKeikanensuu);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_Suiihyou.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_Suiihyou.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

