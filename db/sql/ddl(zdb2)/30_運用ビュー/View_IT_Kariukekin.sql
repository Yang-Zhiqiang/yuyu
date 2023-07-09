CREATE VIEW IT_Kariukekin AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     krkno ,         /* 仮受番号 */
     krkkeijyoymd ,         /* 仮受計上処理日 */
     krkgk ,         /* 仮受金額 */
     krkgk$ ,         /* 仮受金額(通貨型) */
     hasseidenymd ,         /* 発生伝票日付 */
     seisandenymd ,         /* 精算伝票日付 */
     krkseisanzumiflg ,         /* 仮受精算済フラグ */
     krkriyuukbn ,         /* 仮受理由区分 */
     nyknaiyoukbn ,         /* 入金内容区分 */
     nykkeiro ,         /* 入金経路 */
     jyuutouym ,         /* 充当年月 */
     jyutoukaisuuy ,         /* 充当回数（年） */
     jyutoukaisuum ,         /* 充当回数（月） */
     ryosyuymd ,         /* 領収日 */
     hrkkaisuu ,         /* 払込回数 */
     tikiktbrisyuruikbn ,         /* 定期一括払種類区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     creditkessaiyouno           /* クレジットカード決済用番号 */
FROM IT_Kariukekin_Z;