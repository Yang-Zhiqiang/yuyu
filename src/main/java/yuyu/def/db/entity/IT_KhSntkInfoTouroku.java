package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIT_KhSntkInfoTouroku;


/**
 * 契約保全選択情報登録テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhSntkInfoTouroku} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhSntkInfoTouroku<br />
 * @see     PKIT_KhSntkInfoTouroku<br />
 * @see     QIT_KhSntkInfoTouroku<br />
 * @see     GenQIT_KhSntkInfoTouroku<br />
 */
@Entity
public class IT_KhSntkInfoTouroku extends GenIT_KhSntkInfoTouroku {

    private static final long serialVersionUID = 1L;

    public IT_KhSntkInfoTouroku() {
    }

    public IT_KhSntkInfoTouroku(String pSyono,Integer pRenno) {
        super(pSyono,pRenno);
    }



}

