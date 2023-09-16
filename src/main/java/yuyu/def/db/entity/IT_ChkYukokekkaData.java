package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenIT_ChkYukokekkaData;


/**
 * 有効性確認結果データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_ChkYukokekkaData} の JavaDoc を参照してください。<br />
 * @see     GenIT_ChkYukokekkaData<br />
 * @see     PKIT_ChkYukokekkaData<br />
 * @see     QIT_ChkYukokekkaData<br />
 * @see     GenQIT_ChkYukokekkaData<br />
 */
@Entity
public class IT_ChkYukokekkaData extends GenIT_ChkYukokekkaData {

    private static final long serialVersionUID = 1L;

    public IT_ChkYukokekkaData() {
    }

    public IT_ChkYukokekkaData(C_AnsyuusysKbn pAnsyuusyskbn,String pYuukoukekkarenno) {
        super(pAnsyuusyskbn,pYuukoukekkarenno);
    }



}

