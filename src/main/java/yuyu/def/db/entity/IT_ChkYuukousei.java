package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenIT_ChkYuukousei;

/**
 * 有効性確認データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_ChkYuukousei} の JavaDoc を参照してください。<br />
 * @see     GenIT_ChkYuukousei<br />
 * @see     PKIT_ChkYuukousei<br />
 * @see     QIT_ChkYuukousei<br />
 * @see     GenQIT_ChkYuukousei<br />
 */
@Entity
public class IT_ChkYuukousei extends GenIT_ChkYuukousei {

    private static final long serialVersionUID = 1L;

    public IT_ChkYuukousei() {
    }

    public IT_ChkYuukousei(String pKbnkey,C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pSyono) {
        super(pKbnkey,pAnsyuusyskbn,pSyoriYmd,pSyono);
    }

    public IT_ChkYuukousei(C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pAnsyuusyskbn,pSyoriYmd,pSyono);
    }


}

