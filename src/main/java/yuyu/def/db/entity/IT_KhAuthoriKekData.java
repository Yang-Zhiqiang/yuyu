package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenIT_KhAuthoriKekData;


/**
 * オーソリ結果データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhAuthoriKekData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhAuthoriKekData<br />
 * @see     PKIT_KhAuthoriKekData<br />
 * @see     QIT_KhAuthoriKekData<br />
 * @see     GenQIT_KhAuthoriKekData<br />
 */
@Entity
public class IT_KhAuthoriKekData extends GenIT_KhAuthoriKekData {

    private static final long serialVersionUID = 1L;

    public IT_KhAuthoriKekData() {
    }

    public IT_KhAuthoriKekData(C_AnsyuusysKbn pAnsyuusyskbn,String pAuthorikkdatarenno) {
        super(pAnsyuusyskbn,pAuthorikkdatarenno);
    }



}

