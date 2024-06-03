n, w, l = map(int, input().split())
truck = list(map(int, input().split())) # 4 5 6

bridge = [0] * w     # [ 0, 0 ]
time = 0

while bridge:
  time += 1
  bridge.pop(0)  #

  if truck:
    if sum(bridge) + truck[0] <= l:
      bridge.append(truck.pop(0))
    else:
      bridge.append(0)
print(time)