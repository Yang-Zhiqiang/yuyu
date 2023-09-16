package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_HokenryouTmttkn;

/**
 * 保険料積立金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HokenryouTmttkn} の JavaDoc を参照してください。<br />
 * @see     GenIT_HokenryouTmttkn<br />
 * @see     PKIT_HokenryouTmttkn<br />
 * @see     QIT_HokenryouTmttkn<br />
 * @see     GenQIT_HokenryouTmttkn<br />
 */
@Entity
public class IT_HokenryouTmttkn extends GenIT_HokenryouTmttkn {

    private static final long serialVersionUID = 1L;

    public IT_HokenryouTmttkn() {
    }

    public IT_HokenryouTmttkn(String pKbnkey,String pSyono,BizDateYM pTmttkntaisyouym,Integer pRenno) {
        super(pKbnkey,pSyono,pTmttkntaisyouym,pRenno);
    }

    public IT_HokenryouTmttkn(String pSyono,BizDateYM pTmttkntaisyouym,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTmttkntaisyouym,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_HokenryouTmttkn.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_HokenryouTmttkn.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

