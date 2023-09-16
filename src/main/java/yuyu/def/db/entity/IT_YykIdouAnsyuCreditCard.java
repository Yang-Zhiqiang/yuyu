package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_YykIdouAnsyuCreditCard;


/**
 * 予約異動案内収納用クレジット払テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_YykIdouAnsyuCreditCard} の JavaDoc を参照してください。<br />
 * @see     GenIT_YykIdouAnsyuCreditCard<br />
 * @see     PKIT_YykIdouAnsyuCreditCard<br />
 * @see     QIT_YykIdouAnsyuCreditCard<br />
 * @see     GenQIT_YykIdouAnsyuCreditCard<br />
 */
@Entity
public class IT_YykIdouAnsyuCreditCard extends GenIT_YykIdouAnsyuCreditCard {

    private static final long serialVersionUID = 1L;

    public IT_YykIdouAnsyuCreditCard() {
    }

    public IT_YykIdouAnsyuCreditCard(String pKbnkey,String pSyono,String pHenkousikibetukey) {
        super(pKbnkey,pSyono,pHenkousikibetukey);
    }

    public IT_YykIdouAnsyuCreditCard(String pSyono,String pHenkousikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_YykIdouAnsyuCreditCard.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_YykIdouAnsyuCreditCard.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

