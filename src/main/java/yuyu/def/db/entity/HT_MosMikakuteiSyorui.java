package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHT_MosMikakuteiSyorui;


/**
 * 申込未確定書類テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosMikakuteiSyorui} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosMikakuteiSyorui<br />
 * @see     PKHT_MosMikakuteiSyorui<br />
 * @see     QHT_MosMikakuteiSyorui<br />
 * @see     GenQHT_MosMikakuteiSyorui<br />
 */
@Entity
public class HT_MosMikakuteiSyorui extends GenHT_MosMikakuteiSyorui {

    private static final long serialVersionUID = 1L;

    public HT_MosMikakuteiSyorui() {
    }

    public HT_MosMikakuteiSyorui(String pDocumentid) {
        super(pDocumentid);
    }



}

