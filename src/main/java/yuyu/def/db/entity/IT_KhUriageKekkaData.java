package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenIT_KhUriageKekkaData;


/**
 * 売上結果データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhUriageKekkaData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhUriageKekkaData<br />
 * @see     PKIT_KhUriageKekkaData<br />
 * @see     QIT_KhUriageKekkaData<br />
 * @see     GenQIT_KhUriageKekkaData<br />
 */
@Entity
public class IT_KhUriageKekkaData extends GenIT_KhUriageKekkaData {

    private static final long serialVersionUID = 1L;

    public IT_KhUriageKekkaData() {
    }

    public IT_KhUriageKekkaData(C_AnsyuusysKbn pAnsyuusyskbn,String pUriagekekkadatarenno) {
        super(pAnsyuusyskbn,pUriagekekkadatarenno);
    }



}

