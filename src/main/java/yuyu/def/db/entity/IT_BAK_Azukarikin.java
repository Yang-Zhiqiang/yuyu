package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.mapping.GenIT_BAK_Azukarikin;

/**
 * 預り金バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_Azukarikin} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_Azukarikin<br />
 * @see     PKIT_BAK_Azukarikin<br />
 * @see     QIT_BAK_Azukarikin<br />
 * @see     GenQIT_BAK_Azukarikin<br />
 */
@Entity
public class IT_BAK_Azukarikin extends GenIT_BAK_Azukarikin {

    private static final long serialVersionUID = 1L;

    public IT_BAK_Azukarikin() {
    }

    public IT_BAK_Azukarikin(String pKbnkey,String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,C_Tuukasyu pTuukasyu) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pHenkousikibetukey,pTuukasyu);
    }

    public IT_BAK_Azukarikin(String pSyono,String pTrkssikibetukey,String pHenkousikibetukey,C_Tuukasyu pTuukasyu) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHenkousikibetukey,pTuukasyu);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_Azukarikin.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_Azukarikin.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_Azukarikin.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

