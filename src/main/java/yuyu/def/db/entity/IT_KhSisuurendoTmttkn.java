package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhSisuurendoTmttkn;


/**
 * 指数連動積増型年金積立金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhSisuurendoTmttkn} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhSisuurendoTmttkn<br />
 * @see     PKIT_KhSisuurendoTmttkn<br />
 * @see     QIT_KhSisuurendoTmttkn<br />
 * @see     GenQIT_KhSisuurendoTmttkn<br />
 */
@Entity
public class IT_KhSisuurendoTmttkn extends GenIT_KhSisuurendoTmttkn {

    private static final long serialVersionUID = 1L;

    public IT_KhSisuurendoTmttkn() {
    }

    public IT_KhSisuurendoTmttkn(String pKbnkey,String pSyono,BizDateYM pTmttkntaisyouym,Integer pRenno) {
        super(pKbnkey,pSyono,pTmttkntaisyouym,pRenno);
    }

    public IT_KhSisuurendoTmttkn(String pSyono,BizDateYM pTmttkntaisyouym,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTmttkntaisyouym,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhSisuurendoTmttkn.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhSisuurendoTmttkn.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

