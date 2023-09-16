package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_Zennou;

/**
 * 前納バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_Zennou} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_Zennou<br />
 * @see     PKIT_BAK_Zennou<br />
 * @see     QIT_BAK_Zennou<br />
 * @see     GenQIT_BAK_Zennou<br />
 */
@Entity
public class IT_BAK_Zennou extends GenIT_BAK_Zennou {

    private static final long serialVersionUID = 1L;

    public IT_BAK_Zennou() {
    }

    public IT_BAK_Zennou(String pKbnkey,String pSyono,String pTrkssikibetukey,BizDate pZennoukaisiymd,Integer pRenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pZennoukaisiymd,pRenno);
    }

    public IT_BAK_Zennou(String pSyono,String pTrkssikibetukey,BizDate pZennoukaisiymd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pZennoukaisiymd,pRenno);
    }


    private IT_BAK_AnsyuKihon iT_BAKAnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_Zennou.KBNKEY  , referencedColumnName=IT_BAK_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_Zennou.SYONO  , referencedColumnName=IT_BAK_AnsyuKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_Zennou.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_AnsyuKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_AnsyuKihon getBAKAnsyuKihon() {
        return iT_BAKAnsyuKihon;
    }

    public void setBAKAnsyuKihon(IT_BAK_AnsyuKihon pIT_BAK_AnsyuKihon) {
        this.iT_BAKAnsyuKihon = pIT_BAK_AnsyuKihon;
    }

}

