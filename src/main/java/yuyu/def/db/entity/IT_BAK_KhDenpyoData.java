package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIT_BAK_KhDenpyoData;


/**
 * 契約保全伝票データバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhDenpyoData} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhDenpyoData<br />
 * @see     PKIT_BAK_KhDenpyoData<br />
 * @see     QIT_BAK_KhDenpyoData<br />
 * @see     GenQIT_BAK_KhDenpyoData<br />
 */
@Entity
public class IT_BAK_KhDenpyoData extends GenIT_BAK_KhDenpyoData {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhDenpyoData() {
    }

    public IT_BAK_KhDenpyoData(String pDenrenno,String pTrkssikibetukey,Integer pEdano) {
        super(pDenrenno,pTrkssikibetukey,pEdano);
    }



}

