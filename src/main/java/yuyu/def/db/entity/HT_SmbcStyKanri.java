package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenHT_SmbcStyKanri;


/**
 * ＳＭＢＣ進捗管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SmbcStyKanri} の JavaDoc を参照してください。<br />
 * @see     GenHT_SmbcStyKanri<br />
 * @see     PKHT_SmbcStyKanri<br />
 * @see     QHT_SmbcStyKanri<br />
 * @see     GenQHT_SmbcStyKanri<br />
 */
@Entity
public class HT_SmbcStyKanri extends GenHT_SmbcStyKanri {

    private static final long serialVersionUID = 1L;

    public HT_SmbcStyKanri() {
    }

    public HT_SmbcStyKanri(BizDate pDatarenymd,BizNumber pDatasakuseirenno) {
        super(pDatarenymd,pDatasakuseirenno);
    }



}

