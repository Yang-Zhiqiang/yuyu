CREATE VIEW IT_AnsyuKihon AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     jkipjytym ,         /* 次回Ｐ充当年月 */
     tkiktannaitukisuu ,         /* 定期一括案内月数 */
     kjsmhakkouzumiflg ,         /* 控除証明書発行済フラグ */
     syuharaimanymd ,         /* 主契約払満日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_AnsyuKihon_Z;