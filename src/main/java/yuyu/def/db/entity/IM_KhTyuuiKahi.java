package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIM_KhTyuuiKahi;


/**
 * 契約保全注意取扱処理可否マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_KhTyuuiKahi} の JavaDoc を参照してください。<br />
 * @see     GenIM_KhTyuuiKahi<br />
 * @see     PKIM_KhTyuuiKahi<br />
 * @see     QIM_KhTyuuiKahi<br />
 * @see     GenQIM_KhTyuuiKahi<br />
 */
@Entity
public class IM_KhTyuuiKahi extends GenIM_KhTyuuiKahi {

    private static final long serialVersionUID = 1L;

    public IM_KhTyuuiKahi() {
    }

    public IM_KhTyuuiKahi(String pKinouId) {
        super(pKinouId);
    }



}

