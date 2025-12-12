# 1. Start a new detached session named 'multiverse' (or whatever you like)
#    We assume you are currently in your main repo folder
tmux new-session -d -s multiverse

# 2. Split the window horizontally (Create right side)
#    This targets the session 'multiverse' we just created
tmux split-window -h -t multiverse -c ../claude

# 3. Split the left pane vertically (Create bottom-left)
tmux split-window -v -t multiverse:0.0 -c ../gemini

# 4. Split the right pane vertically (Create bottom-right)
tmux split-window -v -t multiverse:0.2 -c ../codex

# 5. Organize them into a nice grid
tmux select-layout -t multiverse tiled

# 6. OPTIONAL: Label the panes so you know which is which
#    (Requires tmux to be inside the pane to set title, so we echo instead)
tmux send-keys -t multiverse:0.0 "echo '--- MAIN BRANCH ---'" C-m
tmux send-keys -t multiverse:0.1 "echo '--- GEMINI ---'" C-m
tmux send-keys -t multiverse:0.2 "echo '--- CLAUDE ---'" C-m
tmux send-keys -t multiverse:0.3 "echo '--- CODEX ---'" C-m

# 7. Finally, attach to the session
tmux attach -t multiverse
