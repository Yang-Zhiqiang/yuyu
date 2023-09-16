package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_NyknJissekiRireki;


/**
 * 入金実績履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_NyknJissekiRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_NyknJissekiRireki<br />
 * @see     PKIT_NyknJissekiRireki<br />
 * @see     QIT_NyknJissekiRireki<br />
 * @see     GenQIT_NyknJissekiRireki<br />
 */
@Entity
public class IT_NyknJissekiRireki extends GenIT_NyknJissekiRireki {

    private static final long serialVersionUID = 1L;

    public IT_NyknJissekiRireki() {
    }

    public IT_NyknJissekiRireki(String pKbnkey,String pSyono,BizDateYM pJyutoustartym,Integer pRenno) {
        super(pKbnkey,pSyono,pJyutoustartym,pRenno);
    }

    public IT_NyknJissekiRireki(String pSyono,BizDateYM pJyutoustartym,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pJyutoustartym,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_NyknJissekiRireki.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_NyknJissekiRireki.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

