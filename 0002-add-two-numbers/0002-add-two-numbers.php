<?php

/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function addTwoNumbers($l1, $l2) {
        $dummyHead = new ListNode(0);
        $tail = $dummyHead;
        $carry = 0;

        while ($l1 || $l2 || $carry) {
            $sum = $carry;

            if ($l1) {
                $sum += $l1->val;
                $l1 = $l1->next;
            }

            if ($l2) {
                $sum += $l2->val;
                $l2 = $l2->next;
            }

            $carry = (int)($sum / 10);
            $sum %= 10;
            $tail->next = new ListNode($sum);
            $tail = $tail->next;
        }

        return $dummyHead->next;
    }
}
?>