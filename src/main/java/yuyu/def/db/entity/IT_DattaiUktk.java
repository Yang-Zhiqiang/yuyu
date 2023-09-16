package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_DattaiUktk;


/**
 * 脱退受付テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_DattaiUktk} の JavaDoc を参照してください。<br />
 * @see     GenIT_DattaiUktk<br />
 * @see     PKIT_DattaiUktk<br />
 * @see     QIT_DattaiUktk<br />
 * @see     GenQIT_DattaiUktk<br />
 */
@Entity
public class IT_DattaiUktk extends GenIT_DattaiUktk {

    private static final long serialVersionUID = 1L;

    public IT_DattaiUktk() {
    }

    public IT_DattaiUktk(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IT_DattaiUktk(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


    private IT_AnsyuKihon iT_AnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_DattaiUktk.KBNKEY  , referencedColumnName=IT_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_DattaiUktk.SYONO  , referencedColumnName=IT_AnsyuKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_AnsyuKihon getAnsyuKihon() {
        return iT_AnsyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pIT_AnsyuKihon) {
        this.iT_AnsyuKihon = pIT_AnsyuKihon;
    }

}

