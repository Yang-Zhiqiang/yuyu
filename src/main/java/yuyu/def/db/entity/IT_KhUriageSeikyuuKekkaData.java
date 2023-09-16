package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhUriageSeikyuuKekkaData;

/**
 * 売上請求結果データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhUriageSeikyuuKekkaData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhUriageSeikyuuKekkaData<br />
 * @see     PKIT_KhUriageSeikyuuKekkaData<br />
 * @see     QIT_KhUriageSeikyuuKekkaData<br />
 * @see     GenQIT_KhUriageSeikyuuKekkaData<br />
 */
@Entity
public class IT_KhUriageSeikyuuKekkaData extends GenIT_KhUriageSeikyuuKekkaData {

    private static final long serialVersionUID = 1L;

    public IT_KhUriageSeikyuuKekkaData() {
    }

    public IT_KhUriageSeikyuuKekkaData(String pKbnkey,String pSyono,String pCreditkessaiyouno,BizDate pUriagenengappi,Integer pRenno3keta) {
        super(pKbnkey,pSyono,pCreditkessaiyouno,pUriagenengappi,pRenno3keta);
    }

    public IT_KhUriageSeikyuuKekkaData(String pSyono,String pCreditkessaiyouno,BizDate pUriagenengappi,Integer pRenno3keta) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pCreditkessaiyouno,pUriagenengappi,pRenno3keta);
    }


}

