CREATE VIEW ZT_KykIdouHaneiKekkaRn AS SELECT
     zrnhuho2kyknokbn ,         /* （連携用）普保Ⅱ契約番号区分 */
     zrnhuho2kykno ,         /* （連携用）普保Ⅱ契約番号 */
     zrnkyknaiyouhaneierrkbn ,         /* （連携用）契約内容反映エラー区分 */
     zrntsnkijyuntyoukahyj ,         /* （連携用）通算基準超過表示 */
     zrnhhknnayosehumeihyj ,         /* （連携用）被保険者名寄せ不明表示 */
     zrnkyknayosehumeihyj ,         /* （連携用）契約者名寄せ不明表示 */
     zrnnkuktnayosehumeihyj ,         /* （連携用）年金受取人名寄せ不明表示 */
     zrntjtidouhaneikekkayobi01           /* （連携用）当日異動内容反映結果予備０１ */
FROM ZT_KykIdouHaneiKekkaRn_Z;