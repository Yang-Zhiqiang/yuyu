package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenHT_BAK_SmbcStyKanri;


/**
 * ＳＭＢＣ進捗管理バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BAK_SmbcStyKanri} の JavaDoc を参照してください。<br />
 * @see     GenHT_BAK_SmbcStyKanri<br />
 * @see     PKHT_BAK_SmbcStyKanri<br />
 * @see     QHT_BAK_SmbcStyKanri<br />
 * @see     GenQHT_BAK_SmbcStyKanri<br />
 */
@Entity
public class HT_BAK_SmbcStyKanri extends GenHT_BAK_SmbcStyKanri {

    private static final long serialVersionUID = 1L;

    public HT_BAK_SmbcStyKanri() {
    }

    public HT_BAK_SmbcStyKanri(BizDate pDatarenymd,String pTrkssikibetukey,BizNumber pDatasakuseirenno) {
        super(pDatarenymd,pTrkssikibetukey,pDatasakuseirenno);
    }



}

