package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenIT_BAK_SyouhnTokujou;


/**
 * 商品特条バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_SyouhnTokujou} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_SyouhnTokujou<br />
 * @see     PKIT_BAK_SyouhnTokujou<br />
 * @see     QIT_BAK_SyouhnTokujou<br />
 * @see     GenQIT_BAK_SyouhnTokujou<br />
 */
@Entity
public class IT_BAK_SyouhnTokujou extends GenIT_BAK_SyouhnTokujou {

    private static final long serialVersionUID = 1L;

    public IT_BAK_SyouhnTokujou() {
    }

    public IT_BAK_SyouhnTokujou(String pKbnkey,String pSyono,String pTrkssikibetukey,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

    public IT_BAK_SyouhnTokujou(String pSyono,String pTrkssikibetukey,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_SyouhnTokujou.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_SyouhnTokujou.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_SyouhnTokujou.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

