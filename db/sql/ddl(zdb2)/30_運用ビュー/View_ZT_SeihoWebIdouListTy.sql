CREATE VIEW ZT_SeihoWebIdouListTy AS SELECT
     ztysakuseiymd7keta ,         /* （中継用）作成年月（７桁） */
     ztybsydrtencd ,         /* （中継用）募集代理店コード */
     ztytntusycd ,         /* （中継用）担当者コード */
     ztysyono ,         /* （中継用）証券番号 */
     ztyhasseiymd ,         /* （中継用）発生日 */
     ztyidoukbn1 ,         /* （中継用）異動区分１ */
     ztykydatkikbnkj ,         /* （中継用）共同扱区分（漢字） */
     ztykykyymm ,         /* （中継用）契約年月（西暦下２桁） */
     ztycifcd ,         /* （中継用）ＣＩＦコード */
     ztymidasikbn ,         /* （中継用）見出し区分 */
     ztyatesakinm ,         /* （中継用）宛先名 */
     ztyhassinka ,         /* （中継用）発信課 */
     ztybsyyymm ,         /* （中継用）募集年月（西暦下２桁） */
     ztytntusynm ,         /* （中継用）担当者名 */
     ztykyknmkjseihoweb ,         /* （中継用）契約者名（漢字）（生保ＷＥＢ） */
     ztypjyuutouyymm ,         /* （中継用）保険料充当年月（西暦下２桁） */
     ztyhrkkaisuukj ,         /* （中継用）払込回数（漢字） */
     ztyp11keta ,         /* （中継用）保険料（１１桁） */
     ztyhrkkeirobtjhmidasi ,         /* （中継用）払込経路別情報見出し */
     ztyhrkkeirobtjh ,         /* （中継用）払込経路別情報 */
     ztytntusyjk ,         /* （中継用）担当者状況 */
     ztyhrkkeirokj ,         /* （中継用）払込経路（漢字） */
     ztyhknsyuruimei ,         /* （中継用）保険種類名 */
     ztyidoukbn2 ,         /* （中継用）異動区分２ */
     ztydbskyoteiymd7keta ,         /* （中継用）ＤＢ削除予定年月（７桁） */
     ztygaikakykhrkp ,         /* （中継用）外貨契約払込保険料 */
     ztykyktuukasyukbn ,         /* （中継用）契約通貨種類区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_SeihoWebIdouListTy_Z;