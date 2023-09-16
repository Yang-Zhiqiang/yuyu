package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_Suiihyou;


/**
 * 推移表バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_Suiihyou} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_Suiihyou<br />
 * @see     PKIT_BAK_Suiihyou<br />
 * @see     QIT_BAK_Suiihyou<br />
 * @see     GenQIT_BAK_Suiihyou<br />
 */
@Entity
public class IT_BAK_Suiihyou extends GenIT_BAK_Suiihyou {

    private static final long serialVersionUID = 1L;

    public IT_BAK_Suiihyou() {
    }

    public IT_BAK_Suiihyou(String pKbnkey,String pSyono,String pTrkssikibetukey,BizDate pTyouhyouymd,Integer pKeikanensuu) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pTyouhyouymd,pKeikanensuu);
    }

    public IT_BAK_Suiihyou(String pSyono,String pTrkssikibetukey,BizDate pTyouhyouymd,Integer pKeikanensuu) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pTyouhyouymd,pKeikanensuu);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_Suiihyou.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_Suiihyou.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_Suiihyou.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

