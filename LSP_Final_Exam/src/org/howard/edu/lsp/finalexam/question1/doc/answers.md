Part 1
Shared resource #1: nextId
Shared resource #2: requests
Concurrency Problem: Race Condition
Why addRequest() is unsafe: addRequest() is unsafe because it performs a "read-modify-write" operation on nextId and modifies a non-thread-safe collection without any synchronization or locking mechanism.

Part 2
Fix A: Incorrect. The (addRequest) method calls requests.add() outside of a synchronized block. Making it so that multiple threads could potentially corrupt the list.

Fix B: Correct. By synchronizing addRequest, only one thread can execute the entire process of getting an ID and adding to the list at a time.

Fix C: Incorrect. It does nothing to protect the state of the list or the nextId variable during the addition process.


Part 3
No, According to Riel’s Heuristic 2.1 ("All data should be hidden within its class"), and specifically the principle that a class should not export its internal implementation details.

Part 4
Description: Use Atomic Variables (specifically AtomicInteger) and Thread-Safe Collections (specifically CopyOnWriteArrayList or Collections.synchronizedList). This avoids the overhead of the synchronized keyword by using low-level "Compare-And-Swap" operations.

Code Snippet:

private AtomicInteger nextId = new AtomicInteger(1);
private List<String> requests = new CopyOnWriteArrayList<>();

public void addRequest(String studentName) {
    int id = nextId.getAndIncrement();
    requests.add("Request-" + id + " from " + studentName);
}