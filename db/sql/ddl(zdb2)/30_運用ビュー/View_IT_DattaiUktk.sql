CREATE VIEW IT_DattaiUktk AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     syoriYmd ,         /* 処理年月日 */
     syorisosikicd ,         /* 処理組織コード */
     dattaikeiro ,         /* 脱退経路 */
     dattairiyuukbn ,         /* 脱退理由区分 */
     dattaiym ,         /* 脱退年月 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     hurihunokbn ,         /* 振替不能理由区分 */
     hurikaeymd ,         /* 振替日 */
     creditdatakbn ,         /* クレジットデータ区分 */
     creditcardno1 ,         /* クレジットカード番号１ */
     creditcardno2 ,         /* クレジットカード番号２ */
     creditcardno3 ,         /* クレジットカード番号３ */
     creditcardno4 ,         /* クレジットカード番号４ */
     creditbrerrorcd ,         /* クレジット払エラーコード */
     jkipjytym ,         /* 次回Ｐ充当年月 */
     comment124keta ,         /* コメント（１２４桁） */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     creditkessaiyouno           /* クレジットカード決済用番号 */
FROM IT_DattaiUktk_Z;