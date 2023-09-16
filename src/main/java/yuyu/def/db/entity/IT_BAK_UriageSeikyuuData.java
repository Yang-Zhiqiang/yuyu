package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_UriageSeikyuuData;

/**
 * 売上請求データバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_UriageSeikyuuData} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_UriageSeikyuuData<br />
 * @see     PKIT_BAK_UriageSeikyuuData<br />
 * @see     QIT_BAK_UriageSeikyuuData<br />
 * @see     GenQIT_BAK_UriageSeikyuuData<br />
 */
@Entity
public class IT_BAK_UriageSeikyuuData extends GenIT_BAK_UriageSeikyuuData {

    private static final long serialVersionUID = 1L;

    public IT_BAK_UriageSeikyuuData() {
    }

    public IT_BAK_UriageSeikyuuData(String pKbnkey,String pSyono,String pTrkssikibetukey,String pCreditkessaiyouno,BizDate pUriagenengappi,Integer pRenno3keta) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pCreditkessaiyouno,pUriagenengappi,pRenno3keta);
    }

    public IT_BAK_UriageSeikyuuData(String pSyono,String pTrkssikibetukey,String pCreditkessaiyouno,BizDate pUriagenengappi,Integer pRenno3keta) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pCreditkessaiyouno,pUriagenengappi,pRenno3keta);
    }


    private IT_BAK_AnsyuKihon iT_BAKAnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_UriageSeikyuuData.KBNKEY  , referencedColumnName=IT_BAK_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_UriageSeikyuuData.SYONO  , referencedColumnName=IT_BAK_AnsyuKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_UriageSeikyuuData.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_AnsyuKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_AnsyuKihon getBAKAnsyuKihon() {
        return iT_BAKAnsyuKihon;
    }

    public void setBAKAnsyuKihon(IT_BAK_AnsyuKihon pIT_BAK_AnsyuKihon) {
        this.iT_BAKAnsyuKihon = pIT_BAK_AnsyuKihon;
    }

}

