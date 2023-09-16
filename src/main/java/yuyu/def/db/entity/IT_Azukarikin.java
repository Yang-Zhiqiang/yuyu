package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.mapping.GenIT_Azukarikin;

/**
 * 預り金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_Azukarikin} の JavaDoc を参照してください。<br />
 * @see     GenIT_Azukarikin<br />
 * @see     PKIT_Azukarikin<br />
 * @see     QIT_Azukarikin<br />
 * @see     GenQIT_Azukarikin<br />
 */
@Entity
public class IT_Azukarikin extends GenIT_Azukarikin {

    private static final long serialVersionUID = 1L;

    public IT_Azukarikin() {
    }

    public IT_Azukarikin(String pKbnkey,String pSyono,String pHenkousikibetukey,C_Tuukasyu pTuukasyu) {
        super(pKbnkey,pSyono,pHenkousikibetukey,pTuukasyu);
    }

    public IT_Azukarikin(String pSyono,String pHenkousikibetukey,C_Tuukasyu pTuukasyu) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey,pTuukasyu);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_Azukarikin.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_Azukarikin.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

