package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenIT_KhSyuunouKekkaData;

/**
 * 収納結果データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhSyuunouKekkaData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhSyuunouKekkaData<br />
 * @see     PKIT_KhSyuunouKekkaData<br />
 * @see     QIT_KhSyuunouKekkaData<br />
 * @see     GenQIT_KhSyuunouKekkaData<br />
 */
@Entity
public class IT_KhSyuunouKekkaData extends GenIT_KhSyuunouKekkaData {

    private static final long serialVersionUID = 1L;

    public IT_KhSyuunouKekkaData() {
    }

    public IT_KhSyuunouKekkaData(String pKbnkey,C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pSyono,BizDateYM pJyuutouym) {
        super(pKbnkey,pAnsyuusyskbn,pSyoriYmd,pSyono,pJyuutouym);
    }

    public IT_KhSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pSyono,BizDateYM pJyuutouym) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pAnsyuusyskbn,pSyoriYmd,pSyono,pJyuutouym);
    }


}

