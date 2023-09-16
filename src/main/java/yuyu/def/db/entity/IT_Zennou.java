package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_Zennou;

/**
 * 前納テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_Zennou} の JavaDoc を参照してください。<br />
 * @see     GenIT_Zennou<br />
 * @see     PKIT_Zennou<br />
 * @see     QIT_Zennou<br />
 * @see     GenQIT_Zennou<br />
 */
@Entity
public class IT_Zennou extends GenIT_Zennou {

    private static final long serialVersionUID = 1L;

    public IT_Zennou() {
    }

    public IT_Zennou(String pKbnkey,String pSyono,BizDate pZennoukaisiymd,Integer pRenno) {
        super(pKbnkey,pSyono,pZennoukaisiymd,pRenno);
    }

    public IT_Zennou(String pSyono,BizDate pZennoukaisiymd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pZennoukaisiymd,pRenno);
    }


    private IT_AnsyuKihon iT_AnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_Zennou.KBNKEY  , referencedColumnName=IT_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_Zennou.SYONO  , referencedColumnName=IT_AnsyuKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_AnsyuKihon getAnsyuKihon() {
        return iT_AnsyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pIT_AnsyuKihon) {
        this.iT_AnsyuKihon = pIT_AnsyuKihon;
    }

}

