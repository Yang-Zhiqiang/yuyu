package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhSisuurendoTmttkn;


/**
 * 指数連動積増型年金積立金バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhSisuurendoTmttkn} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhSisuurendoTmttkn<br />
 * @see     PKIT_BAK_KhSisuurendoTmttkn<br />
 * @see     QIT_BAK_KhSisuurendoTmttkn<br />
 * @see     GenQIT_BAK_KhSisuurendoTmttkn<br />
 */
@Entity
public class IT_BAK_KhSisuurendoTmttkn extends GenIT_BAK_KhSisuurendoTmttkn {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhSisuurendoTmttkn() {
    }

    public IT_BAK_KhSisuurendoTmttkn(String pKbnkey,String pSyono,String pTrkssikibetukey,BizDateYM pTmttkntaisyouym,Integer pRenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pTmttkntaisyouym,pRenno);
    }

    public IT_BAK_KhSisuurendoTmttkn(String pSyono,String pTrkssikibetukey,BizDateYM pTmttkntaisyouym,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pTmttkntaisyouym,pRenno);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhSisuurendoTmttkn.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhSisuurendoTmttkn.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhSisuurendoTmttkn.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

