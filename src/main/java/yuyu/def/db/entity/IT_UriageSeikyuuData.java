package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_UriageSeikyuuData;

/**
 * 売上請求データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_UriageSeikyuuData} の JavaDoc を参照してください。<br />
 * @see     GenIT_UriageSeikyuuData<br />
 * @see     PKIT_UriageSeikyuuData<br />
 * @see     QIT_UriageSeikyuuData<br />
 * @see     GenQIT_UriageSeikyuuData<br />
 */
@Entity
public class IT_UriageSeikyuuData extends GenIT_UriageSeikyuuData {

    private static final long serialVersionUID = 1L;

    public IT_UriageSeikyuuData() {
    }

    public IT_UriageSeikyuuData(String pKbnkey,String pSyono,String pCreditkessaiyouno,BizDate pUriagenengappi,Integer pRenno3keta) {
        super(pKbnkey,pSyono,pCreditkessaiyouno,pUriagenengappi,pRenno3keta);
    }

    public IT_UriageSeikyuuData(String pSyono,String pCreditkessaiyouno,BizDate pUriagenengappi,Integer pRenno3keta) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pCreditkessaiyouno,pUriagenengappi,pRenno3keta);
    }


    private IT_AnsyuKihon iT_AnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_UriageSeikyuuData.KBNKEY  , referencedColumnName=IT_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_UriageSeikyuuData.SYONO  , referencedColumnName=IT_AnsyuKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_AnsyuKihon getAnsyuKihon() {
        return iT_AnsyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pIT_AnsyuKihon) {
        this.iT_AnsyuKihon = pIT_AnsyuKihon;
    }

}

