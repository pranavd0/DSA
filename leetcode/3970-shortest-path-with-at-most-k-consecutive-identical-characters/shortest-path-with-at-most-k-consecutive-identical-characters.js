/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {string} labels
 * @param {number} k
 * @return {number}
 */
var shortestPath = function(n, edges, labels, k) {

    if (n === 1) return 0;

    // Build adjacency list
    const graph = Array.from({ length: n }, () => []);

    for (const [u, v, w] of edges) {
        graph[u].push([v, w]);
    }

    // Distance for each node and consecutive count
    const dist = Array.from(
        { length: n },
        () => new Array(k + 1).fill(Infinity)
    );

    // Min heap
    class MinHeap {
        constructor() {
            this.heap = [];
        }

        push(value) {
            const heap = this.heap;
            heap.push(value);

            let i = heap.length - 1;

            while (i > 0) {
                const p = Math.floor((i - 1) / 2);

                if (heap[p][0] <= heap[i][0]) break;

                [heap[p], heap[i]] = [heap[i], heap[p]];
                i = p;
            }
        }

        pop() {
            const heap = this.heap;
            const top = heap[0];
            const last = heap.pop();

            if (heap.length > 0) {
                heap[0] = last;

                let i = 0;

                while (true) {
                    let smallest = i;
                    const l = 2 * i + 1;
                    const r = 2 * i + 2;

                    if (l < heap.length &&
                        heap[l][0] < heap[smallest][0]) {
                        smallest = l;
                    }

                    if (r < heap.length &&
                        heap[r][0] < heap[smallest][0]) {
                        smallest = r;
                    }

                    if (smallest === i) break;

                    [heap[i], heap[smallest]] =
                        [heap[smallest], heap[i]];

                    i = smallest;
                }
            }

            return top;
        }

        isEmpty() {
            return this.heap.length === 0;
        }
    }

    const pq = new MinHeap();

    // [cost, node, consecutiveCount]
    dist[0][1] = 0;
    pq.push([0, 0, 1]);

    while (!pq.isEmpty()) {

        const [cost, node, count] = pq.pop();

        // Ignore outdated states
        if (cost > dist[node][count]) continue;

        // Destination reached
        if (node === n - 1) return cost;

        for (const [next, weight] of graph[node]) {

            const nextCount =
                labels[node] === labels[next]
                    ? count + 1
                    : 1;

            // Consecutive characters exceed k
            if (nextCount > k) continue;

            const newCost = cost + weight;

            if (newCost < dist[next][nextCount]) {

                dist[next][nextCount] = newCost;

                pq.push([
                    newCost,
                    next,
                    nextCount
                ]);
            }
        }
    }

    return -1;
};
