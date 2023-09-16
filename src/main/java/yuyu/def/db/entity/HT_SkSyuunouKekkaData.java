package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.mapping.GenHT_SkSyuunouKekkaData;


/**
 * 新契約収納結果データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkSyuunouKekkaData} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkSyuunouKekkaData<br />
 * @see     PKHT_SkSyuunouKekkaData<br />
 * @see     QHT_SkSyuunouKekkaData<br />
 * @see     GenQHT_SkSyuunouKekkaData<br />
 */
@Entity
public class HT_SkSyuunouKekkaData extends GenHT_SkSyuunouKekkaData {

    private static final long serialVersionUID = 1L;

    public HT_SkSyuunouKekkaData() {
    }

    public HT_SkSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn,BizDate pSyoriYmd,String pMosno,BizDateYM pJyuutouym) {
        super(pAnsyuusyskbn,pSyoriYmd,pMosno,pJyuutouym);
    }



}

