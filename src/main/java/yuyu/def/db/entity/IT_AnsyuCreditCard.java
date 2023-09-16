package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_AnsyuCreditCard;


/**
 * 案内収納用クレジット払テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_AnsyuCreditCard} の JavaDoc を参照してください。<br />
 * @see     GenIT_AnsyuCreditCard<br />
 * @see     PKIT_AnsyuCreditCard<br />
 * @see     QIT_AnsyuCreditCard<br />
 * @see     GenQIT_AnsyuCreditCard<br />
 */
@Entity
public class IT_AnsyuCreditCard extends GenIT_AnsyuCreditCard {

    private static final long serialVersionUID = 1L;

    public IT_AnsyuCreditCard() {
    }

    public IT_AnsyuCreditCard(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IT_AnsyuCreditCard(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


    private IT_AnsyuKihon iT_AnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_AnsyuCreditCard.KBNKEY  , referencedColumnName=IT_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_AnsyuCreditCard.SYONO  , referencedColumnName=IT_AnsyuKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_AnsyuKihon getAnsyuKihon() {
        return iT_AnsyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pIT_AnsyuKihon) {
        this.iT_AnsyuKihon = pIT_AnsyuKihon;
    }

}

